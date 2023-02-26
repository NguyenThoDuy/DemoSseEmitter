//BootstrapのJavaScript側の機能を読み込む
import "bootstrap";

//Bootstrapのスタイルシートを読み込む
import "./index.scss";

//Fontawesome 機能読み込み
import {config, dom, library} from '@fortawesome/fontawesome-svg-core';
//使用するIconを読み込み
//setFontawesome()にも追加すること
import {
  faGlobe,
  faCheck,
  faCircleCheck,
  faSortDown,
  faSortUp,
  faMagnifyingGlass,
  faChevronLeft,
  faXmark,
  faTriangleExclamation,
} from '@fortawesome/free-solid-svg-icons';


//Toastの初期化
// var toastElList = [].slice.call(document.querySelectorAll(".toast"));
// var toastList = toastElList.map(function (toastEl) {
//   return new bootstrap.Toast(toastEl);
// });

// // toastクラスがついている要素にBootStrapのトーストを適用する
// var toastElList = [].slice.call(document.querySelectorAll(".toast"));
// var toastList = toastElList.map(function (toastEl) {
//   return new bootstrap.Toast(toastEl, {
//     // オプション
//     delay: 10000
//   });
// });



const close = function () {
  const alertList = document.querySelectorAll('.timer-alert');

  let i = 0;

  alertList.forEach(function (alert) {
    setTimeout(function () {
      new bootstrap.Alert(alert).close();
    }, i * 500);

    i++;
  })
}

setTimeout(close, 1000);

class App {
  constructor() {
    this.viewDidLoad();
  }

  viewDidLoad() {
    //window.bootstrap定義
    this.initBootstrap();

    // Tooltipの初期化
    this.initTooltip();

    // Toastの初期化
    this.initToast();

    // Fontawesome Iconsのセット
    this.setFontawesome();
  }

  /**
   * window.bootstrap定義
   */
  initBootstrap() {
    window.bootstrap = require("bootstrap");
  }

  /**
   * Bootstrap Tooltipの初期化
   */
  initTooltip() {
    const tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
    const tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
      return new bootstrap.Tooltip(tooltipTriggerEl)
    });
  }

  /**
   * Bootstrap Toastの初期化
   */
  initToast() {
    // toastクラスがついている要素にBootStrapのトーストを適用する
    this.toastElList = [].slice.call(document.querySelectorAll(".toast"));
    this.toastList = this.toastElList.map(function (toastEl) {
      return new bootstrap.Toast(toastEl, {});
    });
  }

  /**
   * Toastを表示
   */
  showToast() {
    this.toastList.forEach(element => element.show());
  }

  /**
   * Fontawesome Iconsのセット
   */
  setFontawesome() {
    //セット
    library.add(
      faGlobe,
      faCheck,
      faCircleCheck,
      faSortDown,
      faSortUp,
      faMagnifyingGlass,
      faChevronLeft,
      faXmark,
      faTriangleExclamation,
    );

    dom.i2svg();
  }
}

window.App = new App();