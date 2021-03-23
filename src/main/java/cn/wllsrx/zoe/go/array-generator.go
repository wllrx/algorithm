package main

import "fmt"

func main() {
	array := generatorOrderArray(5)
	fmt.Println(array)
}

func generatorOrderArray(n int) []int {
	var arr = make([]int, n)
	for i := 0; i < n; i++ {
		arr[i] = i
	}
	return arr
}
