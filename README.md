Project Title
IIIT_LABS: Lab Seat Reservation System

Table of Contents
Project Title
About
Features
Technologies Used
Flowcharts
Upcoming Features
About
IIIT_LABS is a web-based Lab Seat Reservation System designed to efficiently manage and streamline the booking process of lab seats for students. Given the limited number of seats compared to the total student population, the system ensures fair and organized allocation of seats in various labs.

Built using the robust Spring Boot framework, the application provides high performance, reliability, and ease of use. IIIT_LABS integrates features like seat availability tracking, concurrency control, email notifications, and caching to enhance the user experience.

The system is containerized using Docker and deployed on AWS Elastic Kubernetes Service (EKS) with automated deployment pipelines via GitHub Actions. Persistent storage is ensured for the database and message broker using Kubernetes StatefulSets.

Features
Lab and Seat Listings

Retrieve information about available labs, total seats, and real-time seat availability for booking.
Concurrent Seat Booking

Handles concurrency issues by temporarily locking seat bookings (e.g., for 6 minutes) using Redis to prevent multiple students from reserving the same seat simultaneously.
Asynchronous Email Notifications

Sends automated confirmation emails upon successful seat reservations using RabbitMQ as a message queue for email workers, reducing response times for seat booking.
Caching Mechanism

Implements caching for frequently accessed data, such as lab seat availability, using Redis, reducing database calls and improving application performance.
Containerization

Uses a Multi-Stage Dockerfile to minimize image size and reduce deployment time, ensuring efficient builds and deployments.
CI/CD Pipeline

Automated deployment to AWS EKS using GitHub Actions, ensuring seamless updates and high availability.
Storage Persistence

Ensures persistence of lab seat booking data and RabbitMQ messages using StatefulSets in Kubernetes to prevent data loss in case of pod restarts.
Technologies Used
Spring Boot Framework - Backend development and APIs
RabbitMQ - Asynchronous messaging for email services
Redis Cache - Temporary seat locking and caching mechanism
Docker - Containerization of the application
AWS Elastic Kubernetes Service (EKS) - Container orchestration for deployment
PostgreSQL - Database for storing seat bookings and lab details
GitHub Actions - CI/CD pipeline for deployment automation
Flowcharts
(Include diagrams/flowcharts here to show system architecture, API workflows, and seat reservation process.)

Upcoming Features
Seat Release Notifications

Notify students when temporarily booked seats are released and available for booking.
Lab Usage Reports

Generate reports on seat usage statistics to help optimize lab resources.
Role-Based Access Control

Different access for admins (lab managers) and students for managing labs and bookings.
UI Enhancements

Build a responsive and user-friendly frontend interface for a seamless experience.
Waitlist Feature

Introduce waitlist management for fully booked labs to ensure fairness in seat allocation.
