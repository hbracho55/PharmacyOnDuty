# PharmacyOnDuty

The backend receive two parameters (commmune name and store name) to filter data

The backend is enabled to receive request from frontend (http://127.0.0.1:5173)

#Postman collection
curl --location --request POST 'http://localhost:8080/pharmacies' \
--header 'Content-Type: application/json' \
--data-raw '{
    "commune": "INDEPENDENCIA",
    "store": "INDEPENDENCIA"
}'
