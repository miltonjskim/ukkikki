import React, { useEffect, useState } from 'react';
import { useLocation, useParams } from 'react-router-dom';
import Footer from '../components/layout/Footer';
import Header from '../components/layout/Header';
import KakaoPayTest from '../services/KakaoPayTest';
import AgencyList from '../components/vote/AgencyList';
import CustomCalendar from '../utils/CustomCalendar';
import { publicRequest } from '../hooks/requestMethod';

const UserVotePage = () => {
  const { travelPlanId: travelPlanIdFromUrl } = useParams();
  const location = useLocation();
  const initialSelectedCard = location.state?.selectedCard;
  const [proposals, setProposals] = useState([]);

  // 우선, URL에서 travelPlanId를 가져오고, 만약 location.state가 없다면 이를 사용하도록 함
  const travelPlanId = initialSelectedCard?.travelPlanId || travelPlanIdFromUrl;

  // ✅ 데이터 가져오기 함수
  const fetchProposals = async () => {
    try {
      const response = await publicRequest.get(`/api/v1/travel-plans/${travelPlanId}/proposals`);
      if (response.data?.data) {
        setProposals(response.data.data);
        console.log('✅ 제안서 데이터:', response.data.data);
      }
    } catch (error) {
      console.error('🚨 제안서 데이터 가져오기 실패:', error);
    }
  };

  // ✅ useEffect를 사용하여 컴포넌트가 마운트될 때 데이터 가져오기
  useEffect(() => {
    fetchProposals();
  }, [travelPlanId]);

  return (
    <div className="bg-gray-50 min-h-screen">
      <Header />

      <div className="max-w-4xl mx-auto p-6">
        <h1 className="text-2xl font-bold text-gray-800 mb-6 text-center">
          제안받은 여행사
        </h1>

        {/* 가로 정렬된 여행사 카드 리스트 */}
        <AgencyList
          agencies={agencies}
          onVote={handleVote}
          onDetail={handleDetail}
        />

        {/* 카카오페이 결제 박스 */}
        <div className="mt-8 p-6 bg-white shadow-lg rounded-lg">
          <h2 className="text-lg font-semibold mb-2">예약금 결제</h2>
          <KakaoPayTest />
        </div>
      </div>
      <div>
        <CustomCalendar />
      </div>

      <Footer />
    </div>
  );
};

export default UserVotePage;
