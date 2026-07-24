#!/bin/bash

# Script to delete all duplicate files without .java extension
# Run this script in the repository root directory

echo "Starting deletion of duplicate files without .java extension..."

# Array of all files to delete (without .java extension)
files_to_delete=(
  "Day-1, 1108. defanging an ip address"
  "Day-1, 1295.find no with even digits"
  "Day-2 , 1470.shuffle the array"
  "Day-2 , 1603.design parking system"
  "Day-2, 1.two sums"
  "Day-2, 225.implementing stack using queues"
  "Day-3, 35.search insert position"
  "Day-4, 1600.throne inheritance"
  "Day-4, 8.string to integer"
  "Day-5, 1116.print zero even odd"
  "Day-5, 1226. dining philosophers"
  "Day-5, 65.valid number"
  "Day-7, 520.detect capitals"
  "Day1- 7 Reverse the integer"
  "day - 3 , 20.valid parantheses"
  "day-1, 9.palindrome number"
  "day-3 , 29.divide two integer"
  "day-3 , 509.fibonacci numbers"
  "day-4, 1114. print in order"
  "day-4,1115.print foobar alternatively"
  "day-5 ,1232.check if its straight line"
  "day-5 231.power of two"
  "day-5, 1195.fizzbuzz multithread"
  "day-5, 1232.check if its straight line"
  "day-6 , 14.longest common prefix"
  "day-6, 242.valid anagram"
  "day-6, 344.reverse the string"
  "day-6, 58.len of last words"
  "day-7, 125.valid palindrome"
  "day-7, 1382. balance a binary search tree"
  "day-7, 1768.merge str alternatively"
  "day-8 , 709. to lowercases"
  "day-8, 1002.find common characters"
  "day-8, 415.add strings"
  "day-8, 771.jewels and stone"
  "day-9 500.keyboard rows"
  "day-9, 10.regular expression matching"
  "day-9, 1812.chessboard"
  "day-9, 2108.find 1st palindrome no"
)

deleted_count=0
failed_count=0

# Delete each file
for file in "${files_to_delete[@]}"; do
  if [ -f "$file" ]; then
    git rm "$file"
    echo "✓ Deleted: $file"
    ((deleted_count++))
  else
    echo "✗ File not found: $file"
    ((failed_count++))
  fi
done

# Commit the changes
if [ $deleted_count -gt 0 ]; then
  echo ""
  echo "Committing deletion of $deleted_count duplicate files..."
  git commit -m "Remove $deleted_count duplicate files without .java extension"
  
  echo ""
  echo "Pushing to remote repository..."
  git push
  
  echo ""
  echo "✓ Successfully deleted $deleted_count files"
  echo "✗ Failed to find $failed_count files"
  echo ""
  echo "Cleanup complete! Your repository now only contains .java files."
else
  echo "No files were deleted."
fi
