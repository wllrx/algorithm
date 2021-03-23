package main

import "fmt"

func main() {
	sort([]int{4, 2, 6, 3, 5, 1})
}

func sort(nums []int) {
	length := len(nums)
	for i := 0; i < length; i++ {
		minIndex := i
		for j := i; j < length; j++ {
			if nums[j] < nums[minIndex] {
				minIndex = j
			}
			num := nums[i]
			nums[i] = nums[minIndex]
			nums[minIndex] = num
		}
	}
	fmt.Println(nums)
}
