const backendBaseUrl = "";

// initialize
(function () {
    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    const forms = document.querySelectorAll('.needs-validation');

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
        .forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }

                form.classList.add('was-validated')
            }, false)
        })
})()

// variable to hold request
let createProductRequest;
// bind the submit event of the form
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
    // serialize the data in the form
    const formJsonData = JSON.stringify(getCreateProductFormData());
    console.log('serialized data: ' + formJsonData);
    // fire off the request
    createProductRequest = $.ajax({
        url: backendBaseUrl + "/api/product",
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

function getCreateProductFormData(){
    return {
        serialNumber: $("#createProductSerialNumberTextInput").val(),
        type: $("#createProductTypeTextInput").val(),
        name: $("#createProductNameTextInput").val(),
        minimumOrderQuantity: parseFloat($("#createProductMinimumOrderQuantityTextInput").val()).toFixed(3)
    }
}