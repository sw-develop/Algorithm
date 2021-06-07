/*
* 이진탐색트리 구현 
*/

//전제 : 적정이진트리로 구현 -> 모조 노드를 가지고 있음


#include <stdio.h>
#include <stdlib.h>

typedef struct TreeNode{ //노드 구조체 
  int key; 
  struct TreeNode* parent, * left, * right;
}TreeNode;

typedef struct{
  TreeNode* root; //트리의 루트 노드 가리키는 구조체 포인터 변수 
}TreeType;

void initTree(TreeType* T){ //이진 트리 초기화 
  T->root = (TreeNode*)malloc(sizeof(TreeNode)); //동적할당
  T->root->parent = T->root->left = T->root->right = NULL; //초기화  
}

int isExternal(TreeNode* w){ //말단노드인지 확인하는 함수 
  return (w->left == NULL && w->right == NULL);
}

void expandExternal(TreeNode* w){ //모조노드 2개 생성하여 연결해주는 것 -> 기존에 createNode() 대신해서 쓰이는 거지
  TreeNode* l = (TreeNode*)malloc(sizeof(TreeNode));
  TreeNode* r = (TreeNode*)malloc(sizeof(TreeNode));

  l->left = l->right = NULL;
  r->left = r->right = NULL;
  l->parent = r->parent = w;
  
  w->left = l;
  w->right = r;
}

TreeNode* treeSearch(TreeNode* v, int k){ //주어진 트리에서 key값이 k인 노드 찾는 함수 (속)
  if(isExternal(v)) return v; //모조노드 반환 
  if(k == v->key) return v; 
  else if(k < v->key)
    return treeSearch(v->left, k); //재귀 
  else 
    return treeSearch(v->right, k); //재귀
}

int findElement(TreeType* T, int k){ //주어진 k값을 key로 가진 노드 탐색 함수 (껍데기)
  TreeNode* w = treeSearch(T->root, k);

  if(isExternal(w)) return 0; //주어진 key값을 가진 노드가 없을 때
  else return w->key; 
}

void insertItem(TreeType* T, int k){ //주어진 k값을 key로 가진 노드 삽입함수 
  TreeNode* w = treeSearch(T->root, k); 
  if(!isExternal(w)) //단말노드가 아닐 때 == 해당 key값인 노드가 존재할 때  
    return;
  else{ //모조노드 일 때 == 해당 key값을 가진 노드가 존재하지 않을 때 
    w->key = k;
    expandExternal(w); 
  }
}

void preOrder(TreeNode* root){
  if(isExternal(root)) return; //모조노드일 때
  printf("[%d] ", root->key);
  preOrder(root->left);
  preOrder(root->right);
}

int main(){
  TreeType* T = (TreeType*)malloc(sizeof(TreeType));

  initTree(T);

  insertItem(T, 9);
  insertItem(T, 2);
  insertItem(T, 1);
  insertItem(T, 7);
  insertItem(T, 15);
  insertItem(T, 11);
  preOrder(T->root); printf("\n");
}
