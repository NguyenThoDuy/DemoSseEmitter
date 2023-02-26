let data =[];

//search function f230
function searchFunction(e) {

    let isExist = false;


    let confirmSearch = "編集中のデータが破棄されますがよろしいですか？";
    $('tbody tr').each(function () {
        if ($(this).find('.c-quantity').text() != null) {
            isExist = true;
        }
    });
    if (isExist == true && $("#inputSearchSheetNo").val() != null) {
        if (confirm(confirmSearch) == true) {
            $('.item-row').remove();
            $('input[name="total-b-quantity"]').val(cSum())

            return false;
        } else {
            e.preventDefault();
            return false;
        }
    }
    var inputSearchSheetNo = $('#inputSearchSheetNo').val();
    var inputSearchBrand = $('#inputSearchBrand option:selected').val();
    var inputSearchSeason = $('#inputSearchSeason').val();
    var inputSearchStyle = $('#inputSearchStyle').val();
    var inputSearchMaterial = $('#inputSearchMaterial').val();
    var inputSearchColor = $('#inputSearchColor').val();
    var inputSearchSize = $('#inputSearchSize').val();


    if ($.trim(inputSearchSheetNo) == '') {
        alert("必須項目が入力されていません。")
        return false;
    }

    let data = [
        {
            key: 'seasonId',
            value: inputSearchSeason
        }
    ]
    if ($.trim(inputSearchSheetNo) != '') {
        data.push(
            {
                key: 'sheetNo',
                value: inputSearchSheetNo
            });
    }

    if ($.trim(inputSearchBrand) != '') {
        data.push(
            {
                key: 'brandCd',
                value: inputSearchBrand
            });
    }

    if ($.trim(inputSearchStyle) != '') {
        data.push(
            {
                key: 'style',
                value: inputSearchStyle
            });
    }

    if ($.trim(inputSearchMaterial) != '') {
        data.push(
            {
                key: 'material',
                value: inputSearchMaterial
            });
    }

    if ($.trim(inputSearchColor) != '') {
        data.push(
            {
                key: 'color',
                value: inputSearchColor
            });
    }

    if ($.trim(inputSearchSize) != '') {
        data.push(
            {
                key: 'size',
                value: inputSearchSize
            });
    }

    reloadMultipleParam(data, true);
}

$(document).ready(function(){

    $('.first-qty-c').on('change', function() {

            let val = $(this).val();
            let field = $(this).parent('.c-to-a-qty').find('.field-qty-c');
            let firstCQty = $(this).parent('.c-to-a-qty').find('.f230-c-to-a-first').val();
            let cQtyUpdate = $(this).parent('.c-to-a-qty').find('.field-qty-c');
            console.log("val " + val);
            console.log("filed " + field);
            console.log("cQtyUpdate " + cQtyUpdate);
            console.log("current val " + firstCQty);
            if(parseInt(val) > parseInt(firstCQty)){
                alert("最大値より大きい値が入力されました。\n" + "入カされた値 : " + val + "\n最大値 : " + firstCQty);
                $(this).val(0);
            }else {
                cQtyUpdate.val(val);
            }

    });
});


    // click register button event
    $("#regis-btn").click(function () {
        if (count == 0) {
            alert("登録対象のデータがありません。")
            return false;
        }
        else {
            let confirmSearch = "画面の内容で登録しますか？";
            if (confirm(confirmSearch) == true) {
            }
            else return false;
        }
    });




