# 🌟 Banking Management Microservice 🌟

A modular and scalable banking system designed with microservices architecture. 🚀

---

## 📚 Table of Contents

- [✨ Project Overview](#-project-overview)
- [💡 Features](#-features)
- [🛠️ Planned Features](#️-planned-features)
- [⚙️ Technology Stack](#-technology-stack)
- [🚀 Getting Started](#-getting-started)
  - [🔧 Prerequisites](#-prerequisites)
  - [📂 Cloning the Repository](#-cloning-the-repository)
  - [▶️ Running the Services](#️-running-the-services)
- [🤝 Contributing](#-contributing)
- [📜 License](#-license)

---

## ✨ Project Overview

The **Banking Management Microservice** project simplifies banking operations by dividing tasks into specialized, self-contained services. 🏦 Each service operates independently, enhancing scalability, maintainability, and fault isolation. 💻 

---

## 💡 Features

🚀 The project currently includes the following services:

- **🔗 Service Registry**: Dynamic service discovery and registration.  
- **🛡️ API Gateway**: Centralized entry point for client requests, with intelligent routing.  
- **🔑 Authentication Service**: Secure user authentication and role-based access control.  
- **👤 Customer Service**: Efficient customer data management and operations.  
- **💳 Account Service**: Comprehensive bank account creation and management.  

---

## 🛠️ Planned Features

Here's what's coming next: 🌟

- **💸 Transaction Service**: Managing seamless fund transfers and transactions.  
- **📩 Notification Service**: Automated notifications and alerts for customers.  
- **📊 Reporting Service**: Generating detailed financial and operational reports.  

---

## ⚙️ Technology Stack

This project is built with the following technologies: 🔧

- **🌐 Java**: Primary programming language.  
- **🍃 Spring Boot**: Microservices framework.  
- **🎛️ Spring Cloud Netflix Eureka**: Service discovery and registry.  
- **🌉 Spring Cloud Gateway**: Intelligent routing and API Gateway.  
- **🔒 Spring Security**: Robust security and authorization.  
- **🔨 Maven**: Build and dependency management tool.  
- **📋 H2 Database**: Lightweight, in-memory database for rapid development and testing.  

---

## 🚀 Getting Started

### 🔧 Prerequisites

Make sure you have the following installed:

- **Java Development Kit (JDK)**: Version 11 or higher ☕  
- **Maven**: Version 3.6.0 or higher 📦  
- **Git**: Version control system 🖋️  

---

### 📂 Cloning the Repository

Clone the repository using the command below:

```bash
git clone https://github.com/Manas127-c/Banking_Management_Microservice.git
```

---

### ▶️ Running the Services

Each service runs independently. Here's how to start them:

1. **Service Registry**:
   ```bash
   cd Banking_Management_Microservice/ServiceRegistry
   mvn spring-boot:run
   ```

2. **API Gateway**:
   ```bash
   cd Banking_Management_Microservice/APIGateway
   mvn spring-boot:run
   ```

3. Repeat similar steps for other services:  
   - Authentication Service  
   - Customer Service  
   - Account Service  

**🚨 Note**: Start the **Service Registry** first, followed by **API Gateway**, and then other services to avoid communication issues. ⚡  

---

## 🤝 Contributing

We welcome your contributions! 🎉  
- Fork the repository 🍴  
- Create a feature branch 🛠️  
- Submit a pull request 📬  

Together, let’s build a better banking system! 🚀  

---

🎉 **Happy Coding!** 🚀  

---
