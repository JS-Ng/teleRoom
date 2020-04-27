# base function to split the array
split(){
  cur_temp=$IFS
  IFS="="
  read -ra spt_array <<< $1
  IFS=$cur_temp
  local -n arr=$2
  arr=(${spt_array[*]})
}
# checker 1
checker_version(){
  local my_arr
  split $1 my_arr
  if [ ${my_arr[0]} = "version" ]; then
    echo 0
  else
    echo 1
  fi
}
# find property
read_property(){
  file_name=$1
  while read -r line
  do
    if [ "$(checker_version $line)" = "0" ]; then
      echo $line
    fi
  done < <(grep . $file_name)
}

for i in $(split "123=456"); do
  echo $i
done

cd FFmpegClipper
mvn package
cd ..