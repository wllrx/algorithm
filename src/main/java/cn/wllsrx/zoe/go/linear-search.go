package main

import (
	"fmt"
)

func main() {
	var nums = []int{5, 2, 4, 6, 1, 3}
	fmt.Println(linearSearch(nums, 6))
	fmt.Println(linearSearch(nums, 7))
}
func linearSearch(nums []int, b int) int {
	length := len(nums)
	for i := 0; i < length; i++ {
		if nums[i] == b {
			return i
		}
	}
	return -1
}
