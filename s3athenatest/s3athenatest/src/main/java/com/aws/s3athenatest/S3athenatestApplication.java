
#!/bin/bash

# Check if the user provided the input path
if [ $# -eq 0 ]; then
  echo "Please provide a Hadoop file path."
  exit 1
fi

input_path=$1
result_file="result.txt"
declare -A visited_dirs

# Function to process each directory and write results to result.txt
function process_directory() {
  local directory_path=$1

  # Check if the directory has been visited before
  if [[ ${visited_dirs["$directory_path"]} ]]; then
    return
  fi

  # Mark the directory as visited
  visited_dirs["$directory_path"]=1

  # Get the number of files and total size of the directory
  local file_count=$(hdfs dfs -ls "$directory_path" | grep '^-' | wc -l)
  local dir_size=$(hdfs dfs -du -s -h "$directory_path" | awk '{print $1}')

  # Write results to result.txt
  echo "Directory: $directory_path, Number of Files: $file_count, Size: $dir_size" >> "$result_file"

  # Recursively process subdirectories
  local subdirs=$(hdfs dfs -ls "$directory_path" | grep '^d' | awk '{print $NF}')
  for subdir in $subdirs; do
    process_directory "$subdir"
  done
}

# Clear the result file before starting
> "$result_file"

# Call the function with the input path
process_directory "$input_path"

echo "Results have been stored in $result_file"
