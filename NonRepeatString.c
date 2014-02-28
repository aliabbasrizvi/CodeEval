#include <stdio.h>
#include <string.h>
#define LEN 80

void printNonRepeatingCharacter(char *str) {
  int i;
  int count[26];

  for (i = 0; i < 26; i++) {
    count[i] = 0;
  }

  for (i = 0; str[i] != '\0'; i++) {
    if (str[i] >= 'a' && str[i] <= 'z') {
      count[str[i] - 'a']++;
    }
    if (str[i] >= 'A' && str[i] <= 'Z') {
      count[str[i] - 'A']++;
    }
  }

  for (i = 0; str[i] != '\0'; i++) {
     if (str[i] >= 'a' && str[i] <= 'z') {
       if (count[str[i] - 'a'] == 1) {
         printf("%c\n", str[i]);
         return;
       }
    }
    if (str[i] >= 'A' && str[i] <= 'Z') {
      if (count[str[i] - 'A'] == 1) {
        printf("%c\n", str[i]);
        return;
      }
    }
  }

  printf("No non repeating character\n");
  return;
}

int main(int argc, char *argv[]) {
  FILE *fp;
  char line[LEN];
  int len;

  if (argc != 2) {
    printf("Unsupported number of parameters. Exiting.");
    return 1;
  }

  fp = fopen(argv[1], "r");

  while(fgets(line, LEN, fp)) {
    printNonRepeatingCharacter(line);
  }

  fclose(fp);
  return 0;
}
