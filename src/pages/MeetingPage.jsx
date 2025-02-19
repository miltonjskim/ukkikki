// MeetingPage.jsx
import React, { useEffect, useState } from 'react';
import { useParams, useSearchParams } from 'react-router-dom';
import { OpenVidu } from 'openvidu-browser';

function MeetingPage() {
  const { proposalId } = useParams();
  // 쿼리 파라미터로부터 token, isHost 추출
  const [searchParams] = useSearchParams();
  const token = searchParams.get('token');
  const isHost = searchParams.get('isHost') === 'true';

  const [session, setSession] = useState(null);
  const [publisher, setPublisher] = useState(null);
  const [subscribers, setSubscribers] = useState([]);

  useEffect(() => {
    // 토큰이 없으면 세션 연결 불가
    if (!token) {
      console.error('No token provided. Cannot connect to session.');
      return;
    }

    const OV = new OpenVidu();
    const newSession = OV.initSession();

    newSession.on('streamCreated', (event) => {
      const subscriber = newSession.subscribe(event.stream, undefined);
      setSubscribers((prev) => [...prev, subscriber]);
    });

    newSession.on('streamDestroyed', (event) => {
      setSubscribers((prev) =>
        prev.filter((sub) => sub !== event.stream.streamManager)
      );
    });

    // 세션 연결
    newSession
      .connect(token)
      .then(() => {
        // 호스트면 카메라 ON, 일반 사용자는 오디오만
        if (isHost) {
          const pub = OV.initPublisher(undefined, {
            videoSource: 'camera',
            audioSource: true,
            publishVideo: true,
            publishAudio: true,
          });
          newSession.publish(pub);
          setPublisher(pub);
        } else {
          const pub = OV.initPublisher(undefined, {
            videoSource: false,
            audioSource: true,
            publishVideo: false,
            publishAudio: true,
          });
          newSession.publish(pub);
          setPublisher(pub);
        }
        setSession(newSession);
      })
      .catch((err) => {
        console.error('Error connecting to the session:', err);
      });

    return () => {
      if (newSession) {
        newSession.disconnect();
      }
    };
  }, [token, isHost]);

  return (
    <div>
      <h2>Meeting Page (proposalId: {proposalId})</h2>
      <p>{isHost ? '호스트 모드' : '참가자 모드'}</p>
      <div>
        <h3>My Stream</h3>
        {publisher && (
          <video
            autoPlay={true}
            ref={(ref) => {
              if (ref) publisher.addVideoElement(ref);
            }}
          />
        )}
      </div>
      <div>
        <h3>Other Streams</h3>
        {subscribers.map((sub, i) => (
          <div key={i}>
            <video
              autoPlay={true}
              ref={(ref) => {
                if (ref) sub.addVideoElement(ref);
              }}
            />
            {/* connection.data 안에 백엔드에서 세팅한 닉네임이 들어 있을 수 있음 */}
            <p>{sub.stream.connection.data}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default MeetingPage;
