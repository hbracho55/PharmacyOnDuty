# PharmacyOnDuty

#Postman collection
curl --location --request POST 'http://localhost:8080/pharmacies' \
--header 'Content-Type: application/json' \
--data-raw '{
    "commune": "VIÑA DEL MAR",
    "store": "CRUZ VERDE"
}'
