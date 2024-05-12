start-db:
	docker-compose up -d twitter-postgres #other-db

stop:
	docker-compose down

start-services:
	# cd tweet-service && ./mvnw spring-boot:run &
	# cd feed-service && ./mvnw spring-boot:run &
	sleep 10

test-unit:
	# cd tweet-service && ./mvnw test

test-integration:
	# cd tweet-service && ./mvnw verify
	# cd feed-service && ./mvnw verify

stop-services:
	kill $$(lsof -t -i:8080) # tweet-service port
	kill $$(lsof -t -i:8081) # may be other service