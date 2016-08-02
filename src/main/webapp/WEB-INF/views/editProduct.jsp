<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Edit Product</h1>
            <p class="lead">Please update the product information.</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/productInventory/editProduct" method="post"
                   commandName="product" enctype="multipart/form-data">
            <form:hidden path="productId" value="${product.productId}"/>
            <div class="form-group">
                <label for="name">Name</label>
                <form:input path="productName" id="name" value="${product.productName}" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label for="category">Category</label>
                <label class="checkbox-inline">
                    <form:radiobutton path="productCategory" id="category" value="instrument"/>Instrument</label>
                <label class="checkbox-inline">
                    <form:radiobutton path="productCategory" id="category" value="record"/>Record</label>
                <label class="checkbox-inline">
                    <form:radiobutton path="productCategory" id="category" value="accessory"/>Accessory</label>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <form:textarea path="productDescription" id="description" value="${product.productDescription}" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <form:input path="productPrice" id="price" cssClass="form-control" value="${product.productPrice}"/>
            </div>
            <div class="form-group">
                <label for="condition">Condition</label>
                <label class="checkbox-inline">
                    <form:radiobutton path="productCondition" id="condition" value="new"/>New</label>
                <label class="checkbox-inline">
                    <form:radiobutton path="productCondition" id="condition" value="used"/>Used</label>
            </div>
            <div class="form-group">
                <label for="status">Status</label>
                <label class="checkbox-inline">
                    <form:radiobutton path="productStatus" id="status" value="active"/>Active</label>
                <label class="checkbox-inline">
                    <form:radiobutton path="productStatus" id="status" value="inactive"/>Sold Out</label>
            </div>
            <div class="form-group">
                <label for="stock">Unit in Stock</label>
                <form:input path="productStock" id="stock" cssClass="form-control" value="${product.productStock}"/>
            </div>

            <div class="form-group">
                <label for="manufacturer">Manufacturer</label>
                <form:input path="productManufacture" id="manufacturer" cssClass="form-control" value="${product.productManufacture}"/>
            </div>

            <div class="form-group">
                <label class="control-label" for="productImage">Upload Picture</label>
                <form:input path="productImage" id="productImage" type="file" class="form:input-large"/>
            </div>

            <br><br>
            <input type="submit" value="submit" class="btn btn-default btn-success">
            <a href="<c:url value="/admin/productInventory" />" class="btn btn-default btn-danger">Cancel</a>
        </form:form>


<%@include file="/WEB-INF/views/template/footer.jsp" %>

