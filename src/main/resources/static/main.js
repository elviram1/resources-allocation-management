$(document).on("click", ".open-edit-modal", function () {
    $(".modal-body #editProjectGroupId").val($(this).data('id'));
    $(".modal-body #editProjectGroupAgency").val($(this).data('agency'));
    $(".modal-body #editProjectGroupColor").val($(this).data('color'));
});

$(document).on("click", ".open-delete-modal", function () {
    $(".modal-body #deleteProjectGroupId").val($(this).data('id'));
    $(".modal-body #deleteProjectGroupAgency").val($(this).data('agency'));
    $(".modal-body #deleteProjectGroupColor").val($(this).data('color'));
});