Here is a clean, professional **README.md** for your **API Design + DSA Hackstack Assignment Task**.
You can directly copy-paste this into your GitHub repo.

---

#  DSA & API Design – Assignment Task

This project contains **API design implementations** and **DSA programs** as part of the HackStack Assignment Task.
The project is built using **Spring Boot (Maven)** for backend API design.

---

##  Project Structure

```
Hackstack-Assignment-Task/
│
├── ApiDesign/              # Spring Boot API Design Task
│   ├── src/
│   ├── pom.xml
│   └── README.md (this file)
│
└── DSA/                    # DSA Java Programs
```

---

#  How to Run the Project (Spring Boot API)

### **Prerequisites**

Make sure the following are installed:

* **Java 17+**
* **Maven 3.8+**
* **Git**
* **VS Code / IntelliJ**

---

##  **Running the Spring Boot Backend**

### **1. Navigate to the project folder**

```
cd ApiDesign
```

### **2. Build the project**

```
mvn clean install
```

### **3. Run the project**

```
mvn spring-boot:run
```

### **4. Server runs at**

```
http://localhost:8080
```

---

#  API Endpoints Implemented

## **1. Student Enrollment API**

### **POST /students/{studentId}/courses/{courseId}/enroll**

* Enroll a student in a course
* **Rule:** Students cannot enroll twice

### **GET /students/{studentId}/courses**

* List all courses for a student

---

## **2. Course Rating API**

### **POST /courses/{courseId}/rating**

* Allows a user to submit a rating
* **Rules:**

  * Only enrolled users can rate a course
  * One rating per user per course

### **GET /courses/{courseId}/rating**

* Returns:

  * avgRating
  * totalRatings
  * all user ratings

---

## **3. Lessons API**

### **GET /courses/{courseId}/lessons**

* Returns lessons of a course
* **Rule:** Only enrolled users can access lessons
* If not enrolled → return **403 Forbidden**

---

#  DSA Programs Included

Inside the `/DSA` folder you will find solutions for:

* Balanced Parentheses
* No of Unique Elements
* first non-repeating character in a string

---

# 🛠 Design Assumptions

### **Enrollment System**

* A student must exist before enrollment
* A course must exist
* Enrollment table maintains student-course mapping
* Duplicate enrollments are rejected

### **Rating System**

* Rating allowed only once per user per course
* Rating values allowed: **1 to 5**
* Average rating computed dynamically

### **Lesson Access Rule**

* Lessons are protected resources
* Only users enrolled in the course can view lessons
* Unauthorized users get **HTTP 403**

### **Database Assumptions**

* Using default **H2 in-memory database**
* Tables auto-created using JPA
* No seed data unless added manually

---

#  Tech Stack

| Component  | Technology     |
| ---------- | -------------- |
| Language   | Java 17        |
| Backend    | Spring Boot 3  |
| Build Tool | Maven          |
| Database   | H2 (In-memory) |
| Tooling    | Git, VS Code   |

---

#  How to Contribute

1. Fork the repo
2. Create a feature branch
3. Commit changes
4. Push and create a PR

---

#  Contact

If you have any doubts or need improvements, feel free to reach out!

---

Just tell me!
