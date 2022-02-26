let getProductBomEntryCountRequest;

/**
 * initialization
 */
(function () {
    'use strict'

    // Render initial table
    renderProductBomEntryCountTable();

})()

/**
 * render product material entry count table
 */
function renderProductBomEntryCountTable() {
    // abort any pending request
    if (getProductBomEntryCountRequest) {
        getProductBomEntryCountRequest.abort();
    }
    // fire off the request
    getProductBomEntryCountRequest = $.ajax({
        url: backendBaseUrl + "/products/bom/entryCount",
        type: "get",
        // async: false
    });
    // callback handler that will be called on success
    getProductBomEntryCountRequest.done(function (response) {
        $('#productTableBody tr').remove();
        renderProductBomEntryCountTableBody(response.entryCounts);
    });
    // callback handler that will be called on failure
    getProductBomEntryCountRequest.fail(function (jqXHR, textStatus, errorThrown) {
        console.error("Error occurred during get all products' bom entry count: " + textStatus, errorThrown);
    })
    // callback handler that will be called regardless the request succeeded or not
    getProductBomEntryCountRequest.always(function () {

    });
}

/**
 * render product material entry count table body
 * @param entryCounts
 */
function renderProductBomEntryCountTableBody(entryCounts) {
    const tbody = $('#productBomEntryCountTableBody');
    for (const entryCount of entryCounts) {
        tbody.append('<tr data-bs-toggle="modal" data-bs-target="#editProductBomEntryModal">' +
            '<td class="productBomEntryCountTableRowId">' + entryCount.id + '</td>' +
            '<td class="productBomEntryCountTableRowSerialNumber">' + entryCount.serialNumber + '</td>' +
            '<td class="productBomEntryCountTableRowType">' + entryCount.type + '</td>' +
            '<td class="productBomEntryCountTableRowName">' + entryCount.name + '</td>' +
            '<td class="productBomEntryCountTableRowBomEntryCount">' + entryCount.entryCount + '</td>' +
            '</tr>');
    }
}