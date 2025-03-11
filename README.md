# 🛍️ E-Commerce API (Spring Boot)

A **Spring Boot REST API** for managing products in an e-commerce platform.  
This API allows users to **create, update, delete, search for products, and upload images**.

---

## 🚀 Features
- ✅ **CRUD operations** on products (Create, Read, Update, Delete)
- ✅ **Upload and retrieve product images**
- ✅ **Search products by keyword**
- ✅ **Spring Boot + JPA + Lombok + PostgreSQL Integration**
- ✅ **Stores images in the database (`BYTEA` in PostgreSQL)**

---

## 🛠️ Technologies Used
- **Spring Boot** (Backend Framework)
- **Spring Data JPA** (ORM for database access)
- **PostgreSQL** (Relational Database)
- **Lombok** (Removes boilerplate code)
- **MultipartFile** (For image uploads)
- **Jackson** (Handles JSON serialization)
- **Spring Web** (REST API Development)

---

## 📌 Database Schema (PostgreSQL)
The `Product` table stores product details along with image data.

| Column Name    | Type            | Description |
|---------------|----------------|-------------|
| `id`          | `BIGINT`        | Primary Key (Unique ID) |
| `name`        | `VARCHAR(255)`  | Product Name |
| `description` | `TEXT`          | Product Description |
| `brand`       | `VARCHAR(100)`  | Product Brand |
| `price`       | `DECIMAL(10,2)` | Product Price |
| `category`    | `VARCHAR(100)`  | Product Category |
| `releaseDate` | `DATE`          | Product Release Date |
| `available`   | `BOOLEAN`       | Availability Status |
| `quantity`    | `INTEGER`       | Stock Quantity |
| `imageName`   | `VARCHAR(255)`  | Image Filename |
| `imageType`   | `VARCHAR(100)`  | Image MIME Type |
| `image`       | `BYTEA`         | Image Data |
