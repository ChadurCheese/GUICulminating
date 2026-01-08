# Check all FXML files for XML validity
Write-Host "=== Checking ALL FXML Files ===" -ForegroundColor Cyan

$fxmlFiles = Get-ChildItem -Path "src\resources\FXML" -Filter "*.fxml"

foreach ($file in $fxmlFiles) {
    Write-Host "`n$($file.Name):" -ForegroundColor Yellow
    
    # Check first 3 characters for BOM
    $bytes = [System.IO.File]::ReadAllBytes($file.FullName)[0..2]
    if ($bytes[0] -eq 0xEF -and $bytes[1] -eq 0xBB -and $bytes[2] -eq 0xBF) {
        Write-Host "  Has UTF-8 BOM" -ForegroundColor Red
    } else {
        Write-Host "  No BOM" -ForegroundColor Green
    }
    
    # Check first line
    $firstLine = Get-Content $file.FullName -TotalCount 1
    if ($firstLine -match '^\s*$') {
        Write-Host "  First line is empty/whitespace" -ForegroundColor Red
    } elseif ($firstLine.StartsWith('<?xml')) {
        Write-Host "  Has XML declaration" -ForegroundColor Green
    } else {
        Write-Host "  Missing XML declaration" -ForegroundColor Red
        Write-Host "  First line: $firstLine" -ForegroundColor Gray
    }
}