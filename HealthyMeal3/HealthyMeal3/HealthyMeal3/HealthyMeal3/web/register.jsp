<%-- 
    Document   : register
    Created on : Jun 7, 2024, 11:06:39 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Title</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />

        <!-- Bootstrap CSS v5.2.1 -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
            />
    </head>

    <body style="
          background: url(./asset/img/background-register.jpg);
          background-position: center;
          background-size: cover;
          ">
        <!-- Section: Design Block -->
        <!-- Section: Design Block -->
        <section class=" container text-center py-4 d-flex justify-content-center align-items-center"style="width: 45%; height: 100vh">
            <style>
                .cascading-right {
                    margin-right: -50px;
                }

                @media (max-width: 991.98px) {
                    .cascading-right {
                        margin-right: 0;
                    }
                }
            </style>

            <!-- Jumbotron -->
            <div style="width: 100%">
                <div class="row g-0 align-items-center" style="position: relative">
                    <div class="col-lg-6 mb-5 mb-lg-0">
                        <div
                            class="card cascading-right bg-body-tertiary"
                            style="backdrop-filter: blur(30px)"
                            >
                            <div class="card-body p-5 shadow-5 text-center">
                                <h2 class="fw-bold mb-5">Sign up now</h2>
                                <form action="MainController">
                                    <!-- 2 column grid layout with text inputs for the first and last names -->
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <div data-mdb-input-init class="form-outline">
                                                <input
                                                    name="first"
                                                    type="text"
                                                    id="form3Example1"
                                                    class="form-control"
                                                    />
                                                <label class="form-label" for="form3Example1"
                                                       >First name</label
                                                >
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <div data-mdb-input-init class="form-outline">
                                                <input
                                                    name="last"
                                                    type="text"
                                                    id="form3Example2"
                                                    class="form-control"
                                                    />
                                                <label class="form-label" for="form3Example2"
                                                       >Last name</label
                                                >
                                            </div>
                                        </div>
                                    </div>

                                    <!-- Email input -->
                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <input
                                            name="email"
                                            type="email"
                                            id="form3Example3"
                                            class="form-control"
                                            />
                                        <label class="form-label" for="form3Example3"
                                               >Email address</label
                                        >
                                    </div>

                                    <!-- Password input -->
                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <input
                                            name="password"
                                            type="password"
                                            id="form3Example4"
                                            class="form-control"
                                            />
                                        <label class="form-label" for="form3Example4"
                                               >Password</label
                                        >
                                    </div>

                                    <!-- Checkbox -->

                                    <!-- Submit button -->
                                    <button
                                        name="action"
                                        value="register"
                                        type="submit"
                                        data-mdb-button-init
                                        data-mdb-ripple-init
                                        class="btn btn-primary btn-block mb-4"
                                        >
                                        Sign up
                                    </button>
                                    <p class="text-danger">${requestScope.mess}</p>
                                    <p class="text-center text-muted mt-5 mb-0">
                                        Have already an account?
                                        <a href="MainController?action=loginpage" class="fw-bold text-body"><u>Login here</u></a>
                                    </p>
                                </form>
                            </div>
                        </div>
                    </div>

                    <div
                        style="position: absolute; left: 52%; z-index: -1"
                        class="col-lg-6 mb-5 mb-lg-0"
                        >
                        <img
                            style="
                            height: 600px;
                            background-size: cover;
                            background-position: right;
                            "
                            src="./asset/img/register-picture.jpg"
                            class="w-100 rounded-4 shadow-4"
                            alt=""
                            />
                    </div>
                </div>
            </div>
            <!-- Jumbotron -->
        </section>
        <!-- Section: Design Block -->
        <!-- Section: Design Block -->
        <!-- Bootstrap JavaScript Libraries -->
        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"
        ></script>

        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
