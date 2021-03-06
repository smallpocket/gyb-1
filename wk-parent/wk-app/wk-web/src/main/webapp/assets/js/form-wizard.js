var demoFormWizard = function () {
    return {
        init: function () {
            $("#stepy").stepy({
                backLabel: "Previous Step",
                nextLabel: "Next Step",
                errorImage: true,
                block: true,
                validate: true
            });
            $('#stepy').validate({
                errorPlacement: function (error) {
                    $('#stepy .stepy-errors').append(error);
                }, rules: {'email': 'required'}, messages: {'email': {required: 'email address is required!'}}
            });
        }
    };
}();
$(function () {
    "use strict";
    demoFormWizard.init();
});