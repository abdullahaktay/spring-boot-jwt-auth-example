# Spring Boot JWT Auth Example

JWT-based stateless authentication API built with Spring Boot and Java 21.

## Tech Stack
- Java 21
- Spring Boot 3.x
- Spring Security
- JSON Web Tokens (JWT)
- PostgreSQL

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
Place the generated files under `secrets/`:
```
- public.pem         # JWT public key
- private.pkcs8.pem  # JWT private key (PKCS#8)
```

## Configuration
Copy .env.example to .env and adjust values:
```env
POSTGRES_USER=your_user
POSTGRES_DB=authdb
PGADMIN_DEFAULT_EMAIL=admin@example.com
```
Place the following files under `secrets/`:
```
- pg_password       # Database password
- pgadmin_password  # pgAdmin password
```

## Run (Gradle)
```bash
./gradlew bootRun
```

## Run with Docker Compose
Build the jar:
```bash
./gradlew bootJar
```
Build the image:
```bash
docker build -t jwt:local .
```
Create persistent volume (only once):
```bash
docker volume create pgdata
```
Start services:
```bash
docker compose up -d
```
## Services
 - API: `http://localhost:8080`
 - pgAdmin: `http://localhost:5050`
