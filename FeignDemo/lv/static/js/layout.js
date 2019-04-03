var Layout = function () {
    var isMobileDevice = function() {
        return  ((
            navigator.userAgent.match(/Android/i) ||
            navigator.userAgent.match(/BlackBerry/i) ||
            navigator.userAgent.match(/iPhone|iPad|iPod/i) ||
            navigator.userAgent.match(/Opera Mini/i) ||
            navigator.userAgent.match(/IEMobile/i)
        ) ? true : false);
    }

    var WindowWidth = $(window).width();
    var WindowHeight = $(window).height();

    var handleScrolling = function () {
        $(".scroll").on("click", function(event) {
            event.preventDefault();//the default action of the event will not be triggered
            $("html, body").animate({scrollTop:($("#"+this.href.split("#")[1]).offset().top)}, 600);
        });
    }

    /* Smooth scrolling and smart navigation when user scrolls on one-page sites */
    var handleNavItemCurrent = function () {
        $(".header-navigation").onePageNav({
            currentClass: "current",
            scrollThreshold: 0
        });
    }

    function handleBootstrap() {
        $(".carousel").carousel({
            interval: 15000,
            pause: "hover"
        });
        $(".tooltips").tooltip();
        $(".popovers").popover();
    }

    function handleCounter() {
        /*$('.counter').counterUp({
            delay: 10,
            time: 1000
        });*/
    }

    var handlePortfolioSorting = function () {
        /*$(".sorting-grid").mixitup();*/
    }

    var handleFancybox = function () {
        if (!jQuery.fancybox) {
            return;
        }
        $(".zoom").fancybox();
    }

    var handleMobiToggler = function () {
        $(".mobi-toggler").on("click", function(event) {
            event.preventDefault();//the default action of the event will not be triggered
            
            $(".header").toggleClass("menuOpened");
            $(".header").find(".header-navigation").toggle(300);            
        });

        function SlideUpMenu () {
            $(".header-navigation a").on("click", function(event) {
                if ($(window).width()<1024) {
                    event.preventDefault();//the default action of the event will not be triggered
                    $(".header-navigation").slideUp(100);
                    $(".header").removeClass("menuOpened");
                }
            });
            $(window).scroll(function() {
                if (($(window).width()>480)&&($(window).width()<1024)) {
                    $(".header-navigation").slideUp(100);
                    $(".header").removeClass("menuOpened");
                }
            });
        }
        SlideUpMenu();
        $(window).resize(function() {
            SlideUpMenu();
        });
    }

 
        
    function valignCenterMessageFunction () {
         MessageCurrentElemHeight = $(".message-block .valign-center-elem").height();

        $(".message-block .valign-center-elem").css("position", "absolute")
            .css ("top", "50%")
            .css ("margin-top", "-"+MessageCurrentElemHeight/2+"px")
            .css ("width", "100%")
            .css ("height", MessageCurrentElemHeight);
    }

    function valignCenterPortfolioFunction () {
         PortfolioCurrentElemHeight = $(".portfolio-block .valign-center-elem").height();

        $(".portfolio-block .valign-center-elem").css("position", "absolute")
            .css ("top", "50%")
            .css ("margin-top", "-"+PortfolioCurrentElemHeight/2+"px")
            .css ("width", "100%")
            .css ("height", PortfolioCurrentElemHeight);
    }

    var valignCenterMessage = function () {
        valignCenterMessageFunction();
        $(window).resize(function() {
            valignCenterMessageFunction();
        });
    }
    var valignCenterPortfolio = function () {
        valignCenterPortfolioFunction();
        $(window).resize(function() {
            valignCenterPortfolioFunction();
        });
    }
    function getMapFunction(){
        
        var map = new BMap.Map("allmap");  // 创建Map实例

        // 添加带有定位的导航控件
        var navigationControl = new BMap.NavigationControl({
            // 靠左上角位置
            anchor: BMAP_ANCHOR_TOP_LEFT,
            // LARGE类型
            type: BMAP_NAVIGATION_CONTROL_LARGE,
            // 启用显示定位
            enableGeolocation: true
        });
        map.addControl(navigationControl);

        var point = new BMap.Point(121.426806,31.270354);
        var marker = new BMap.Marker(point);  // 创建标注
        map.addOverlay(marker);              // 将标注添加到地图中
        map.centerAndZoom(point, 15);
        var opts = {
            width : 0,     // 信息窗口宽度
            height: 0,     // 信息窗口高度
            title : "上海天航旅游咨询有限公司" , // 信息窗口标题
            enableMessage:false,//设置允许信息窗发送短息
        }
        var infoWindow = new BMap.InfoWindow("地址：上海市 普陀区 新村路666号兴远科技园10号楼209室", opts);  // 创建信息窗口对象      
        map.openInfoWindow(infoWindow,point); //开启信息窗口
        map.enableScrollWheelZoom(true);
    }
    var getMap = function(){
        getMapFunction();
        $(window).resize(function() {
            getMapFunction();
        });
        
    }

    
    return {
        init: function () {
            handleScrolling();
            handleNavItemCurrent();
            handleBootstrap();
            handleCounter();
            handlePortfolioSorting();
            handleFancybox();
            handleMobiToggler();
            valignCenterMessage();
            valignCenterPortfolio();
            getMap();
        },
    };
}();