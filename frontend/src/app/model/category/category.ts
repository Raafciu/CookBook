export class Category {
  id: number;
  name: string;
  categoryPhoto: string;
  parentId: number;
  children: [];

  constructor(id: number, name: string, categoryPhoto?: string, parentId?: number, children?: []) {
    this.id = id;
    this.name = name;
    this.categoryPhoto = categoryPhoto;
    this.parentId = parentId;
    this.children = children;
  }
}
