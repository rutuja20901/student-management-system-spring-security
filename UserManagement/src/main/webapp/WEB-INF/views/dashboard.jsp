<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">

    <title>Student Dashboard</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<!-- ✅ NAVBAR -->
<nav class="navbar navbar-dark bg-dark px-4">
    <span class="navbar-brand mb-0 h1">Student Management</span>

    <form action="/logout" method="post">
        <button class="btn btn-outline-light btn-sm">Logout</button>
    </form>
</nav>

<!-- ✅ MAIN CONTAINER -->
<div class="container mt-4">

    <!-- Add Student Button -->
    <div class="d-flex justify-content-end mb-3">
        <button class="btn btn-primary"
                data-bs-toggle="modal"
                data-bs-target="#studentModal">
            + Add Student
        </button>
    </div>

    <!-- ✅ STUDENT TABLE CARD -->
    <div class="card shadow-sm">
        <div class="card-header bg-primary text-white">
            Student List
        </div>

        <div class="card-body p-0">
            <table class="table table-striped table-hover mb-0">
                <thead class="table-light">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Age</th>
                    <th class="text-center">Actions</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${students}" var="s">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.name}</td>
                        <td>${s.email}</td>
                        <td>${s.age}</td>
                        <td class="text-center">
                            <button class="btn btn-sm btn-warning"
                                    data-bs-toggle="modal"
                                    data-bs-target="#studentModal"
                                    onclick="editStudent('${s.id}','${s.name}','${s.email}','${s.age}')">
                                Edit
                            </button>

                            <a href="/students/delete/${s.id}"
                               class="btn btn-sm btn-danger"
                               onclick="return confirm('Delete this student?')">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>

                <c:if test="${empty students}">
                    <tr>
                        <td colspan="5" class="text-center text-muted">
                            No students found
                        </td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- ✅ STUDENT MODAL -->
<div class="modal fade" id="studentModal" tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

            <form action="/students/save" method="post">

                <div class="modal-header bg-primary text-white">
                    <h5 class="modal-title">Student Form</h5>
                    <button type="button" class="btn-close btn-close-white"
                            data-bs-dismiss="modal"></button>
                </div>

                <div class="modal-body">

                    <input type="hidden" name="id" id="studentId"/>

                    <div class="mb-3">
                        <label class="form-label">Name</label>
                        <input type="text" name="name" id="name"
                               class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <input type="email" name="email" id="email"
                               class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Age</label>
                        <input type="number" name="age" id="age"
                               class="form-control" required>
                    </div>

                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-success">Save</button>
                    <button type="button" class="btn btn-secondary"
                            data-bs-dismiss="modal">Cancel</button>
                </div>

            </form>

        </div>
    </div>
</div>

<!-- ✅ JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

<script>
function editStudent(id, name, email, age) {
    document.getElementById("studentId").value = id;
    document.getElementById("name").value = name;
    document.getElementById("email").value = email;
    document.getElementById("age").value = age;
}
</script>

</body>
</html>
