export class Category {
  id: number;
  name: string;
  categoryPhoto: string;
  parentId: number;

  constructor(id: number, name: string, categoryPhoto?: string, parentId?: number) {
    this.id = id;
    this.name = name;
    this.categoryPhoto = categoryPhoto;
    this.parentId = parentId;
  }
}
