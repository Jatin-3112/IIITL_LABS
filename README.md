# **Project Title**  
**IIIT_LABS: Lab Seat Reservation System**  

---

## **Table of Contents**  
1. [Project Title](#project-title)  
2. [About](#about)  
3. [Features](#features)  
4. [Technologies Used](#technologies-used)  
5. [Flowcharts](#flowcharts)  
6. [Upcoming Features](#upcoming-features)  
7. [How to Run](#how-to-run)  
8. [Contributions](#contributions)  

---

## **About**  
IIIT_LABS is a web-based **Lab Seat Reservation System** designed to efficiently manage and streamline the booking process of lab seats for students. Given the limited number of seats compared to the total student population, the system ensures fair and organized allocation of seats in various labs.  

Built using the robust **Spring Boot framework**, the application provides high performance, reliability, and ease of use. IIIT_LABS integrates features like seat availability tracking, concurrency control, email notifications, and caching to enhance the user experience.  

The system is containerized using **Docker** and deployed on **AWS Elastic Kubernetes Service (EKS)** with automated deployment pipelines via **GitHub Actions**. Persistent storage is ensured for the database and message broker using Kubernetes StatefulSets.  

---

## **Features**  

1. **Lab and Seat Listings**  
   - Retrieve information about available labs, total seats, and real-time seat availability for booking.  

2. **Concurrent Seat Booking**  
   - Handles concurrency issues by temporarily locking seat bookings (e.g., for 6 minutes) using **Redis** to prevent multiple students from reserving the same seat simultaneously.  

3. **Asynchronous Email Notifications**  
   - Sends automated confirmation emails upon successful seat reservations using **RabbitMQ** as a message queue for email workers, reducing response times for seat booking.  

4. **Caching Mechanism**  
   - Implements caching for frequently accessed data, such as lab seat availability, using **Redis**, reducing database calls and improving application performance.  

5. **Containerization**  
   - Uses a **Multi-Stage Dockerfile** to minimize image size and reduce deployment time, ensuring efficient builds and deployments.  

6. **CI/CD Pipeline**  
   - Automated deployment to **AWS EKS** using **GitHub Actions**, ensuring seamless updates and high availability.

7. **Storage Persistence**  
   - Ensures persistence of lab seat booking data and RabbitMQ messages using **StatefulSets** in Kubernetes to prevent data loss in case of pod restarts.  

---

## **Technologies Used**  

- **Spring Boot Framework** - Backend development and APIs  
- **RabbitMQ** - Asynchronous messaging for email services  
- **Redis Cache** - Temporary seat locking and caching mechanism  
- **Docker** - Containerization of the application  
- **AWS Elastic Kubernetes Service (EKS)** - Container orchestration for deployment  
- **PostgreSQL** - Database for storing seat bookings and lab details  
- **GitHub Actions** - CI/CD pipeline for deployment automation  

---

## **Flowcharts**  
(Add diagrams/flowcharts here to show system architecture, API workflows, and seat reservation process.)  

---

## **Upcoming Features**  

1. **Seat Release Notifications**  
   - Notify students when temporarily booked seats are released and available for booking.  

2. **Lab Usage Reports**  
   - Generate reports on seat usage statistics to help optimize lab resources.  

3. **Role-Based Access Control**  
   - Different access for admins (lab managers) and students for managing labs and bookings.  

4. **UI Enhancements**  
   - Build a responsive and user-friendly frontend interface for a seamless experience.  

5. **Waitlist Feature**  
   - Introduce waitlist management for fully booked labs to ensure fairness in seat allocation.  
