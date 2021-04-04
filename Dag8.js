function storsteProdukt(tall, n) {
  var sum = 0;
  for (let i = 0; i < tall.length - n + 1; i++) {
    lst = tall.substring(i, i + n).split("")
    var tmp = lst[0]
    for (let j = 1; j < lst.length; j++) {
      tmp *= lst[j]
    }
    if (tmp > sum) {
      sum = tmp
    }
  }
  return sum
}
