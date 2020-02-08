#!/bin/sh
# 需要提前配置ssh pubKey

mvn clean package -DskipTests
scp -r ./target/jyy-google-1.0-SNAPSHOT.jar root@47.89.12.2:/root/
#ssh root@101.132.149.31 "sh /root/jyy/run.sh"
# ssh root@47.99.60.142
#jyygoogleserver/udxdGJOU1717