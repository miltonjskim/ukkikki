#!/bin/bash

# jar 파일 이름을 명시적으로 지정하여 프로세스 검색
JARFILE="ukkikki-0.0.1-SNAPSHOT.jar"
for pid in $(pgrep -f ${JARFILE}); do
    sudo kill -15 ${pid}
    echo "kill process ${pid}"
done

sleep 5

cd /home/ubuntu/ukkikki
chmod +x ./${JARFILE}

export MYSQL_URL=i12c204.p.ssafy.io:3306/ukkikki
export MYSQL_USERNAME=developer
export MYSQL_PASSWORD=Cnacnsmsdhfkddnxks204!
export KAKAO_CLIENT_ID=543bdf326c0ceabaa5b9e7a4f4478805
export GOOGLE_CLIENT_ID=364985393520-d9ppdqb97767slvbk8855obfjdqipo95.apps.googleusercontent.com
export GOOGLE_CLIENT_SECRET=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 
export REDIS_HOST=i12c204.p.ssafy.io
export AWS_ACCESS_KEY=AKIAQ4J5X2PNU6UGKYWB
export AWS_SECRET_KEY=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
export AWS_S3_BUCKET_NAME=ukkikki-bucket
export MONGO_HOST=i12c204.p.ssafy.io
export MONGO_PORT=27017
export MONGO_DATABASE=ukkikki
export OPENVIDU_URL=https://i12c204.p.ssafy.io:8443
export OPENVIDU_SECRET=Cnacnsmsdhfkddnxks204
export KEY_STORE_PATH=/etc/letsencrypt/live/i12c204.p.ssafy.io/i12c204.jks
export KEY_STORE_PASSWORD=Cnacnsmsdhfkddnxks204! 

echo "Starting application..."
nohup java -jar ./${JARFILE} > application.log 2>&1 </dev/null &

# 새로운 프로세스 시작 확인
sleep 5
NEW_PID=$(pgrep -f ${JARFILE})
if [ -n "${NEW_PID}" ]; then
    echo "Application started successfully with PID: ${NEW_PID}"
    # 시작 로그 확인
    echo "=== Startup Logs ==="
    tail -n 50 application.log
    exit 0
else
    echo "Failed to start application"
    echo "=== Error Logs ==="
    tail -n 100 application.log
    exit 1
fi
