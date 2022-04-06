$('document').ready(function () {

    $('.table .open-edit-modal').on('click', function (){
        $(".modal-body #editId").val($(this).data('id'));
        $(".modal-body #editProject").val($(this).data('project'));
        $(".modal-body #editResource").val($(this).data('resource'));
        $(".modal-body #editResourceFollowed").val($(this).data('resourcefollowed'));
        $(".modal-body #editStartDate").val($(this).data('startdate'));
        $(".modal-body #editEndDate").val($(this).data('enddate'));
        $(".modal-body #editAllocatedHours").val($(this).data('allocatedhours'));
        $(".modal-body #editSupport").val($(this).data('support'));
        $(".modal-body #editInvestment").val($(this).data('investment'));
        $(".modal-body #editHypothesis").val($(this).data('hypothesis'));
        $(".modal-body #editMetadata").val($(this).data('metadata'));
    });

    $('.table #deleteButton').on('click', function (event){
        event.preventDefault();
        let href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href',href);
        $('#deleteModal').modal();
    });

});