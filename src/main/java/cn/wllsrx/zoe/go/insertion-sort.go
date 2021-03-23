package main

import "fmt"

func main() {
	insertionSort([]int{5, 2, 4, 6, 1, 3})
}

func insertionSort(arr []int) {
	for i := 0; i < len(arr); i++ {
		for j := i; j-1 >= 0 && arr[j] < arr[j-1]; j-- {
			a := arr[j-1]
			arr[j-1] = arr[j]
			arr[j] = a
		}
	}
	fmt.Println(arr)
}
