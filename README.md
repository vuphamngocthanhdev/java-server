# ☕ Java Server

A lightweight, high-performance Java backend server designed for modern development.  
Built on **Arch Linux**, powered by **Java 21**, and optimized with **Maven Daemon** for blazing-fast builds.

---

## 🌐 Project Description

This project provides a minimal yet powerful Java server template, ideal for microservices, REST APIs, or backend
logic.  
It's pre-configured with tools and dependencies that ensure fast startup, easy development, and production-readiness.

---

## 🛠️ Environment Setup

| Tool/Component      | Version / Description                                  |
|---------------------|--------------------------------------------------------|
| 🐧 **OS**           | Arch Linux – `Kernel 6.15.4` (📅 Released: 2025-07-01) |
| ☕ **Java**          | `Java 21 (21.0.7-librca)`                              |
| 🚀 **Build Tool**   | `Maven Daemon (mvnd 1.0.2)`                            |
| 🧪 **SonarQube**    | `SonarQube` (📅 Released: 25.7.0.110598)               |
| 📁 **Project Type** | Maven-based Java application                           |

---

## ✨ Features

- ⚡ Fast build performance using **mvnd**
- 🧪 Support for modern **Java 21** language features
- 🔧 Optimized for **Arch Linux** developer environments
- 📦 Easy to extend for microservice or REST API development
- 📜 Clean project structure with best practices

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
  git clone https://github.com/vuphamngocthanhdev/java-server.git
  cd java-server
```

### 2. 🔍 Use SonarQube for Code Quality

#### Step 1: Start SonarQube (locally via Docker)

```bash
  docker run -d --name sonarqube -p 9000:9000 sonarqube:community
```

> Access SonarQube at: [http://localhost:9000](http://localhost:9000)  
> Default login: `admin` / `admin`

---

#### Step 2: Generate a token on SonarQube

1. Go to **My Account** → **Security**
2. Generate a token (e.g., `java-server-token`)
3. Copy and save the token securely

---

#### Step 3: Run Sonar analysis

```bash
   mvn clean verify sonar:sonar \
        -Dsonar.projectKey='your_project_key' \
        -Dsonar.projectName='your_project_name' \
        -Dsonar.host.url=http://localhost:9000 \
        -Dsonar.token='your_generated_token'
```

> Replace `your_generated_token` with the actual token you got in Step 2.

---