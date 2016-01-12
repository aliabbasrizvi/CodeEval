#include <stdio.h>
#include <string.h>

void printReverse(char *str) {
  int len = strlen(str) - 1;
  int i, j, k;
  char tmpChar;
  int startPoint;
  
  for (i = 0, j = len - 1; i < j; i++, j--) {
    tmpChar = str[i];
    str[i] = str[j];
    str[j] = tmpChar;
  }

  startPoint = 0;
  for (i = 0; i < len; i++) {
    if (str[i] == ' ' || i == len - 1) {
      if (i == len - 1) {
        j = i;
      } else {
        j = i - 1;
      }
      for (k = startPoint; k < j; k++, j--) {
        tmpChar = str[k];
        str[k] = str[j];
        str[j] = tmpChar;
      }
      startPoint = i + 1;
    }
  }
  printf("%s", str);
}

int main(int argc, char *argv[]) {
  FILE *fp;
  char *str;
  size_t len;

  if (argc != 2) {
    printf("Incorrect number of parameters passed. Exiting.");
    return 1;
  }

  fp = fopen(argv[1], "r");
  getline(&str, &len, fp);
  while (!feof(fp)) {
    printReverse(str);
    getline(&str, &len, fp);
  }
  fclose(fp);
  return 0;
}
