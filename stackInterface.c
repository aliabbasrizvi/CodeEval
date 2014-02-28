#include <stdio.h>
#include <stdlib.h>

struct node {
  int data;
  struct node *next;
}*first;
int size;

void push (int val) {
  struct node *newnode;
  newnode = (struct node*)malloc(sizeof(struct node));
  newnode->data = val;
  newnode->next = first;
  first = newnode;
  size++;
}

int pop () {
  struct node *tmp;
  int val;
  tmp = first;
  val = first->data;
  first = first->next;
  free(tmp);
  size--;
  return val;
}

int main(int argc, char *argv[]) {
  FILE *fp;
  char *str;
  size_t len;
  int linelen;
  int num;
  int i;
  int negativeCheck;

  if (argc != 2) {
    printf("Unsupported number of parameters passed. Exiting.\n");
    return 1;
  }

  fp = fopen(argv[1], "r");
  linelen = getline(&str, &len, fp);
  negativeCheck = 0;
  while(!feof(fp)) {
    first = NULL;
    i = 0;
    size = 0;
    linelen--;
    while(i < linelen) {
      num = 0;
      if (str[i] == '-') {
        negativeCheck = 1;
        i++;
        continue;
      } 

      while (str[i] != ' ' && i < linelen) {
        num = num*10 + (str[i] - '0');
        i++;
      }

      if (negativeCheck) {
        num = -num;
        negativeCheck = 0;
      }
      push(num);
      i++;
    }
    while (size > 0) {
      printf("%d ", pop());
      if (size > 0) {
        pop();
      }
    }
    printf("\n");
    linelen = getline(&str, &len, fp);
  }

  return 0;
}
