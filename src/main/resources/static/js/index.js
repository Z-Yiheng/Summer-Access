// 瀑布流
function waterFall() {
    var columns = 3;
    var itemWidth = 365;
    var arr = [];
    console.log(itemWidth);
    $(".content_body .my_item").each(function(i) {
        var height = $(this).height();
        if (i < columns) {
            $(this).css({
                top: 0,
                left: (itemWidth) * i,
            });
            arr.push(height);
        } else {
            var minHeight = arr[0];
            var index = 0;
            for (var j = 0; j < arr.length; j++) {
                if (minHeight > arr[j]) {
                    minHeight = arr[j];
                    index = j;
                }
            }
            $(this).css({
                top: arr[index],
                left: $(".content_body .my_item").eq(index).css("left")
            });
            arr[index] = arr[index] + height;
        }
    })
}

window.onresize = function() {
    waterFall();
}

window.onload = function() {
    waterFall();
}