# PharmacyOnDuty

The backend receive two parameters (commmune name and store name) to filter data

The backend is enabled to receive request from frontend (http://127.0.0.1:5173)

Execute docker container:
1. docker build -t "pharmacy-app" . (from root project directory)
2. docker run --name java-app -p 8080:8080 pharmacy-app


#Postman collection
curl --location --request POST 'http://localhost:8080/pharmacies' \
--header 'Content-Type: application/json' \
--data-raw '{
    "commune": "INDEPENDENCIA",
    "store": "INDEPENDENCIA"
}'
