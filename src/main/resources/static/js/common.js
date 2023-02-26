// datatable dom-text plugin
// $.fn.dataTable.ext.order['dom-text'] = function  ( settings, col )
// {
//   return this.api().column( col, {order:'index'} ).nodes().map( function ( td, i ) {
//     return $('input', td).val();
//   } );
// };

// reload page when searching
let reload = (key, value, removeQuery) => {
  let url = new URL(window.location);
  if (removeQuery) {
    url.search = '';
  }
  // define new url with searching condition
  (url.searchParams.has(key) ? url.searchParams.set(key, value) : url.searchParams.append(key, value));
  url.search = url.searchParams.toString();
  url = url.toString();
  // reload the page
  window.location = url;
};

// reload page when searching with multiple parameters
let reloadMultipleParam = (data, removeQuery) => {
  let url = new URL(window.location);
  if (removeQuery) {
    url.search = '';
  }
  // define new url with searching condition
  data.forEach(element => {
    (url.searchParams.has(element.key) ? url.searchParams.set(element.key, element.value) : url.searchParams.append(element.key, element.value));
  })
  url.search = url.searchParams.toString();
  url = url.toString();
  // reload the page
  window.location = url;
};

let priorityChange = (className) => {
  $(className).focusin(function () {
    // get previous value
    $(this).data('val', $(this).val());
  }).change(function () {
    window.hasChange = true;
    let prev = $(this).data('val');
    // get current value
    let current = $(this).val();
    // get element id
    let eid = $(this).attr('id');

    // check current value existence
    let count = 0;
    $(className).each(function () {
      if ($(this).val() === current) count ++;
    });

    if (count > 1 && current < prev) {
      $(className).each(function () {
        if (Number($(this).val()) >= Number(current) && Number($(this).val()) < Number(prev) && $(this).attr('id') !== eid) {
          // increase 1 to matching input element
          $(this).val(Number($(this).val()) + 1);
        }
      });
    }
    if (count > 1 && current > prev) {
      $(className).each(function () {
        if (Number($(this).val()) <= Number(current) && Number($(this).val()) > Number(prev) && $(this).attr('id') !== eid) {
          // decrease 1 to matching input element
          $(this).val(Number($(this).val()) - 1);
        }
      });
    }
  })
}
