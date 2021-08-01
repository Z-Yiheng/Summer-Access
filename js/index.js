// 此处为左上角按钮js
$("#btn").click(function() {
    $("#header").show(1000);
    $("#btn").hide(250);
    return false
})

$("#close").click(function() {
    $("#header").hide(250);
    $("#btn").show(500);
    return false
})

// 此处为底部换背景按钮
$("#open_bg_change").click(function() {
    $("#bg_container").show(250);
    $("#open_bg_change").hide(250);
    return false
})

$("#bg_container_close").click(function() {
    $("#bg_container").hide(250);
    $("#open_bg_change").show(500);
    return false
})

//触碰显示


//导航栏动态模糊
let x = 0;
let x_new = 0;
let x_offset = 0;

let banner = document.querySelector(".banner");
let images = document.querySelectorAll(".image");

let window_width = document.documentElement.clientWidth;
let step = window_width / 2 / 5; // 屏幕移动 1/2 屏幕宽度，模糊度发生 5px 变化
//   console.log("step: ", step);
let data_images = [{
    x: 0,
    b: 4
}, {
    x: 0,
    b: 0
}, {
    x: 0,
    b: 1
}, {
    x: 0,
    b: 4
}, {
    x: 0,
    b: 5
}, {
    x: 0,
    b: 6
}, ];

// 初始函数
let init = () => {
    for (const key in images) {
        if (images.hasOwnProperty(key)) {
            const element = images[key];
            const element_data = data_images[key];
            element.children[0].style = `transform: .2s linear; transform: translate(${element_data.x}px); filter: blur(${element_data.b}px);`;
        }
    }
};

// 鼠标悬停
banner.addEventListener("mouseover", (e) => {
    x = e.clientX;
    // console.log(x);
});

// 鼠标移入
banner.addEventListener("mousemove", (e) => {
    x_new = e.clientX;
    // console.log(x_new);
    x_offset = x - x_new;
    // console.log(x_offset);
    for (const key in images) {
        if (images.hasOwnProperty(key)) {
            let level = (6 - parseInt(key)) * 10;
            const element = images[key];
            const element_data = data_images[key];
            let b_new = Math.abs(element_data.b + x_offset / step);
            let l_new = 0 - x_offset / level;
            element.children[0].style = `transform: translate(${l_new}px);filter:blur(${b_new}px);`;
        }
    }
});

// 鼠标移出恢复默认
banner.addEventListener("mouseout", (e) => {
    init();
});



//置顶按钮
$(window).scroll(function() {
    if ($(document).scrollTop() > 160) {
        $('.to_top_btn').fadeIn();
    } else {
        $('.to_top_btn').fadeOut();
    }
});
$('.to_top_btn').click(function() {
    var timer = setInterval(function() {
        if ($(document).scrollTop() == 0) {
            clearInterval(timer);
        } else {
            $(document).scrollTop($(document).scrollTop() - 30);
        }
    }, 5);
});


//悬浮窗口
function displayWindow_QQ() {
    // /*悬浮窗口的显示,需要将display变成block*/1
    // document.getElementById("window_QQ").style.display = "block";
    // /*将背景变暗*/
    // document.getElementById("shadow").style.display = "block";
    $("#window_QQ").show(400);
    $("#shadow").show();
}

function displayWindow_Wechat() {
    $("#window_Wechat").show(400);
    $("#shadow").show();

}

/*当点击调用此方法,将悬浮窗口和背景全部隐藏*/
function hideWindow_QQ() {
    $("#window_QQ").hide();
    $("#shadow").hide();
    // document.getElementById("window_QQ").style.display = "none";
    // document.getElementById("shadow").style.display = "none";
}

function hideWindow_Wechat() {
    $("#window_Wechat").hide();
    $("#shadow").hide();
}