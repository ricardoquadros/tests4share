#!/bin/bash

file1="file01.txt"
file2="file02.txt"
file3="file03.txt"
output="matches.txt"

> "$output"

arrayFiles=(file0?.txt)

for file in "${arrayFiles[@]}"; do
    if [ ! -f "$file" ]; then
        echo "File $file does not exist"
        exit 1
    fi

    awk '{print substr($0, 1, 5)}' "$file" | sed 's/[[:space:]]*$//' | sort -u > temp_"$file"
done

grep -Fxf temp_file01.txt temp_file02.txt | while read -r match; do
    echo "Match Found: '$match' in both files" >> "$output"
done

rm -f temp_file01.txt temp_file02.txt

echo "Matching results saved in $output"
