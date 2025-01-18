Sample Spring Boot application to validate local Llama LLM instance using Ollama API Server.

Prerequisites:
Ollama API Server
Llama LLM

Postman requests:
curl --location 'http://localhost:8095/api/v1/ai/generate?prompt=How%20to%20make%20orange%20juice%3F'

curl --location 'http://localhost:8095/api/v1/ai/generateStream?prompt=How%20to%20make%20orange%20juice%3F'
