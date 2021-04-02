lst = Array.from({length: 100}, (_, i) => i + 1)
lst.splice(93, 1)
console.log(lst)
console.log(anagram('heijaja', 'iajajhe'))

function hyppigstTegn(str) {
  dict = {}
  for (var char in str) {
    console.log(char)
    if (dict[str[char]] === undefined) {
      dict[str[char]] = 1
    } else {
      dict[str[char]] += 1
    }
  }
  console.log(dict)
  var most_common
  var count = 0
  for (var ele in dict) {
    if (dict[ele] > count) {
      most_common = ele
      count = dict[ele]
    }
  }
  return most_common
}

function anagrasm(w1, w2) {
  w1 = w1.toLowerCase()
  w2 = w2.toLowerCase()
  if (w1.length !== w2.length) {
    return false
  }
  var lst1 = []
  var lst2 = []
  for (var char in w1) {
    lst1.push(w1[char])
    lst2.push(w2[char])
  }
  lst1.sort()
  lst2.sort()
  console.log(lst1, lst2)
  for (let i=0; i<lst1.length; i++) {
    if (lst1[i] === lst2[i]) {
        //pass
    } else {
      return false
    }
  }
  return true
}

function skjevtOrd(w1, w2) {
  if (w1.length !== w2.length) {
    return false
  }
  for (let i=0; i<w1.length; i++) {
    if (w1 == w2) {
      return true
    } else {
      w2 = w2.substring(w2.length -1) + w2.substring(0, w2.length -1)
    }
  }
  return false
}

function manglendeTall(arr) {
  var step = Math.floor(arr.length / 2)
  var pointer = step
  while (step > 1) {
    step = Math.floor(step / 2)
    if (arr[pointer] === pointer + 1) {
      pointer += step
    } else {
      pointer -= step
    }
  }
  return pointer + 1
}

function anagram (a, b) {
    var y = a.split("").sort().join(""),
        z = b.split("").sort().join("");
    return z === y
        ? true
        : false
}
