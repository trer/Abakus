function area(matrix) {
  console.log(matrix)
  n = matrix.length
  var X = []
  var Y = []
  var points = []
  dance:
  for (let i=0; i<n; i++) {
  	for (let j=0; j<n; j++) {
  		if (matrix[i][j] === 1) {
         	X.push(i)
          Y.push(j)
          points.push([j, i])
        	if (X.length === 3) {
            break dance;
          }
        }
  	}
  }
  console.log(X, Y)
  
  let area = 0.0;
  let j = 2;
  for (let i=0; i < 3; i++) {
  	area += (X[j] + X[i]) * (Y[j] - Y[i]);
    j=i
  }
  return Math.round(Math.abs(area / 2.0))
}
