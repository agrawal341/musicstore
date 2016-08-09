<%@include file="/WEB-INF/views/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="login-box">
            <h2>Login with Username and Password.</h2>

            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>
            <form name="loginForm" action="processlogin" method="post">
                <c:if test="${not empty error}">
                    <div class="error">${error}</div>
                </c:if>
                <div class="form-group">
                    <label for="username">User: </label>
                    <input type="text" id="username" name="username" class="form-control">
                </div>
                <div class="form-group">
                    <label for="password">Password: </label>
                    <input type="password" id="password" name="password" class="form-control">
                </div>

                <input type="submit" value="Submit" class="btn btn-default btn-success">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            </form>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>