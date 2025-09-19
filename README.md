# Spring Boot JWT Auth Example

JWT-based stateless authentication API built with Spring Boot and Java 21.

## Tech Stack
- Spring Boot 3.x
- Spring Security
- JSON Web Tokens (JWT)
- Java 21

## Generate RSA Keys
This project requires an RSA key pair for signing and verifying JWTs.

Generate keys with OpenSSL:
```bash
# Generate private key
openssl genrsa -out private.pem 2048

# Extract public key
openssl rsa -in private.pem -pubout -out public.pem

# Convert private key to PKCS#8 format
openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in private.pem -out private.pkcs8.pem
```
Place the generated files under src/main/resources/keys/:
- public.pem
- private.pkcs8.pem

## Run (Gradle)
```bash
./gradlew bootRun
```

## Run with Docker
Build the jar:
```bash
./gradlew bootJar
```
Build the image:
```bash
docker build -t jwt:local .
```
Run the container:
```bash
docker run --rm -p 8080:8080 jwt:local
```
