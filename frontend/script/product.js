/**
 * initialization
 */
(function () {
    'use strict'

    // Register events
    document.getElementById("createProductForm").addEventListener("submit", createProduct);

    // Render initial table
    renderProductTable();
})()

let createProductRequest;

/**
 * create product when createProductForm form is submitted
 */
function createProduct() {
    // cancel submit if the form is invalid.
    if (!document.getElementById('createProductForm').checkValidity()) {
        console.log('One of the inputs in create product form is invalid.');
        return;
    }
    // abort any pending request
    if (createProductRequest) {
        createProductRequest.abort();
    }
    // select and cache all the fields
    const $inputs = $('#createProductForm').find("input, select, button, textarea");
    // disable the inputs for the duration of the ajax request
    $inputs.prop('disabled', true);
    // serialize the data of the form in JSON
    const formJsonData = JSON.stringify(getCreateProductFormData());
    // fire off the request
    createProductRequest = $.ajax({
        url: backendBaseUrl + "/product",
        type: "post",
        contentType: "application/json",
        dataType: 'json',
        async: false,
        data: formJsonData
    });
    // callback handler that will be called on success
    createProductRequest.done(function () {
        console.log("Product created.");
    });
    // callback handler that will be called on failure
    createProductRequest.fail(function (jqXHR, textStatus, errorThrown) {
        console.error("Error occurred during product creation: " + textStatus, errorThrown);
    })
    // callback handler that will be called regardless the request succeeded or not
    createProductRequest.always(function () {
        $inputs.prop("disabled", false);
    });
}

/**
 * get values from inputs of createProductForm form
 * @returns {{serialNumber: (*|string|jQuery), minimumOrderQuantity: string, name: (*|string|jQuery), type: (*|string|jQuery)}}
 */
function getCreateProductFormData(){
    return {
        serialNumber: $("#createProductSerialNumberTextInput").val(),
        type: $("#createProductTypeTextInput").val(),
        name: $("#createProductNameTextInput").val(),
        minimumOrderQuantity: parseFloat($("#createProductMinimumOrderQuantityTextInput").val()).toFixed(3)
    }
}

let getProductsRequest;

/**
 * render product table
 */
function renderProductTable() {
    // abort any pending request
    if (getProductsRequest) {
        getProductsRequest.abort();
    }
    // fire off the request
    getProductsRequest = $.ajax({
        url: backendBaseUrl + "/products",
        type: "get",
        async: false
    });
    // callback handler that will be called on success
    getProductsRequest.done(function (response) {
        $('#productTableBody tr').remove();
        renderProductTableBody(response.products);
    });
    // callback handler that will be called on failure
    getProductsRequest.fail(function (jqXHR, textStatus, errorThrown) {
        console.error("Error occurred during get all products: " + textStatus, errorThrown);
    })
    // callback handler that will be called regardless the request succeeded or not
    getProductsRequest.always(function () {

    });
}

/**
 * render product table body
 * @param products
 */
function renderProductTableBody(products) {
    const tbody = $('#productTableBody');
    for (const product of products) {
        tbody.append('<tr>')
            .append('<th scope="row">' + product.id + '</th>')
            .append('<th>' + product.serialNumber + '</th>')
            .append('<th>' + product.type + '</th>')
            .append('<th>' + product.name + '</th>')
            .append('<th>' + product.minimumOrderQuantity + '</th>')
            .append('</tr>');
    }
}
