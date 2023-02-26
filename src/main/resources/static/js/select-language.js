$(function () {
  let setCookie = (key, value, expiry) => {
    let expires = new Date();
    expires.setTime(expires.getTime() + (expiry * 24 * 60 * 60 * 1000));
    document.cookie = key + '=' + value + ';expires=' + expires.toUTCString();
  }
  $('#selectLanguage').on("change", function() {
    let lang = $('#selectLanguage option:selected').val();
    setCookie('locale', lang, 365);
    location.reload();
  });
});