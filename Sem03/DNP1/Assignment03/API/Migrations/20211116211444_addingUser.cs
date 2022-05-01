using Microsoft.EntityFrameworkCore.Migrations;

namespace API.Migrations
{
    public partial class addingUser : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Adults_Job_JobTitleId",
                table: "Adults");

            migrationBuilder.DropPrimaryKey(
                name: "PK_Adults",
                table: "Adults");

            migrationBuilder.RenameTable(
                name: "Adults",
                newName: "Adult");

            migrationBuilder.RenameIndex(
                name: "IX_Adults_JobTitleId",
                table: "Adult",
                newName: "IX_Adult_JobTitleId");

            migrationBuilder.AddPrimaryKey(
                name: "PK_Adult",
                table: "Adult",
                column: "Id");

            migrationBuilder.AddForeignKey(
                name: "FK_Adult_Job_JobTitleId",
                table: "Adult",
                column: "JobTitleId",
                principalTable: "Job",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Adult_Job_JobTitleId",
                table: "Adult");

            migrationBuilder.DropPrimaryKey(
                name: "PK_Adult",
                table: "Adult");

            migrationBuilder.RenameTable(
                name: "Adult",
                newName: "Adults");

            migrationBuilder.RenameIndex(
                name: "IX_Adult_JobTitleId",
                table: "Adults",
                newName: "IX_Adults_JobTitleId");

            migrationBuilder.AddPrimaryKey(
                name: "PK_Adults",
                table: "Adults",
                column: "Id");

            migrationBuilder.AddForeignKey(
                name: "FK_Adults_Job_JobTitleId",
                table: "Adults",
                column: "JobTitleId",
                principalTable: "Job",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }
    }
}
