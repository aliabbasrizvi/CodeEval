#include <stdio.h>

void capitalizeWords(char str[]) {
  int i;
  int diff = 'A' - 'a';

  for (i = 0; str[i] != '\0'; i++) {
    while (str[i] == ' ') {
      i++;
    }
    if (str[i] >= 'a' && str[i] <= 'z') {
      str[i]+=diff;
      i++;
    }
    while(str[i] != ' ' && str[i] != '\0') {
      i++;
    }
  }

  printf("%s",str);
}

int main(int argc, char*argv[]) {
  FILE *fp;
  size_t len;
  char *str;

  if (argc != 2) {
    printf("Unsupported number of parameters passed. Exiting.");
    return 1;
  }

  fp = fopen(argv[1], "r");
  getline(&str, &len, fp);
  while(!feof(fp)) {
    capitalizeWords(str);
    getline(&str, &len, fp);
  }

  return 0;
}
