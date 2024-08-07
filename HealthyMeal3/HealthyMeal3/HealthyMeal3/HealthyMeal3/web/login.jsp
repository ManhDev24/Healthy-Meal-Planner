<%-- 
    Document   : login
    Created on : Jun 7, 2024, 11:06:29 PM
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
        <link rel="stylesheet" href="./asset/login.css" />
    </head>

    <body>
        <section class="vh-100">
            <div class="container-fluid h-custom">
                <div class="row d-flex justify-content-center align-items-center h-100" style="position: relative; width: 100%">
                    <div class="col-md-9 col-lg-6 col-xl-5" style="position: absolute; z-index: -1; right: 34%">
                        <img
                            src="./asset/img/about.jpg"
                            class="img-fluid"
                            alt="Sample image"
                            style="transform: scaleX(-1)"
                            />
                    </div>

                    <div class="col-md-8 col-lg-6 col-xl-4" style="width: 458px; margin-left: 422px; margin-top: 62px">
                        <form class="d-flex flex-column justify-content-center pt-5" action="MainController" >
                            <div
                                class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                            </div>


                             
                            <!-- Email input -->
                            <p class="text-danger">${requestScope.error}</p>
                            <div data-mdb-input-init class="form-outline mb-4">
                                <input
                                    name="txtemail"
                                    type="text"
                                    id="form3Example3"
                                    class="form-control form-control-lg"
                                    placeholder="Your Email"
                                    />
                                <label class="form-label" for="form3Example3"
                                       >Email address</label
                                >
                            </div>

                            <!-- Password input -->
                            <div data-mdb-input-init class="form-outline mb-3">
                                <input
                                    name="txtpassword"
                                    type="password"
                                    id="form3Example4"
                                    class="form-control form-control-lg"
                                    placeholder="Enter the password"
                                    />
                                <label class="form-label" for="form3Example4">Password</label>
                            </div>

                            <div class="d-flex justify-content-between align-items-center">
                                <!-- Checkbox -->
                                <div class="form-check mb-0">
                                    <input
                                        class="form-check-input me-2"
                                        type="checkbox"
                                        value=""
                                        id="form2Example3"
                                        />
                                    <label class="form-check-label" for="form2Example3">
                                        Remember me
                                    </label>
                                </div>
                                <a href="requestPassword" class="text-body">Forgot password?</a>
                            </div>

                            <div class="text-center text-lg-start mt-4 pt-2">
                                <button
                                    name="action"
                                    value="login"
                                    type="submit"
                                    data-mdb-button-init
                                    data-mdb-ripple-init
                                    class="btn btn-primary btn-lg"
                                    style="padding-left: 2.5rem; padding-right: 2.5rem"
                                    placeholder="Login"
                                    >
                                    Login
                                </button>
                                <p class="small fw-bold mt-2 pt-1 mb-0">
                                    Don't have an account?
                                    <a href="MainController?action=registerpage" class="link-danger">Register</a>
                                </p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Right -->
        </section>
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
